package az.example.atl7.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.Charset.defaultCharset;

public class AuthUtility {
    private static String AUTH_TOKEN = null;
    private static final int TOKEN_AGE = 10;
    public static final String BEARER = "Bearer";

    private AuthUtility() {
    }

    private static String getNewToken(ResourceLoader resourceLoader, String pin, String fullName) {
        AUTH_TOKEN = generateToken(resourceLoader, pin, fullName);
        return AUTH_TOKEN;
    }

    @SneakyThrows
    private static String generateToken(ResourceLoader resourceLoader, String pin, String fullName) {
        LocalDateTime now = LocalDateTime.now();
        String token;
        Map<String, Object> claims = new HashMap<>();

        claims.put("PIN", pin);
        claims.put("FullName", fullName);
        claims.put("exp", LocalDateTime.now().plusHours(TOKEN_AGE).atZone(ZoneId.systemDefault()).toEpochSecond());


        PrivateKey privateKey = readPrivateKey(resourceLoader);
        token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.RS256, privateKey).compact();

        return BEARER + " " + token;
    }

    private static PrivateKey readPrivateKey(ResourceLoader resourceLoader) throws Exception {
        java.security.Security.addProvider(
                new BouncyCastleProvider()
        );
        InputStream inputStream = resourceLoader
                .getResource("classpath:keys/jwtRSA256-private.pem")
                .getInputStream();
        String key = new String(inputStream.readAllBytes(), defaultCharset());

        String privateKeyPEM = key
                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END RSA PRIVATE KEY-----", "");

        byte[] encoded = Base64.decodeBase64(privateKeyPEM);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return keyFactory.generatePrivate(keySpec);
    }

}