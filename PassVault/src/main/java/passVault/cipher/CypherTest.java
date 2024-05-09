package passVault.cipher;

import java.util.Scanner;

/* This Is the main class for the code
 * This will use the codes in the Encoder, Decoder, and CypherKey classes to encode or decode a typed-in String
 * This will prompt the user to choose between encoding a text, decoding an encoded text (using the Cypher Key given in the CypherKey class), or print out the cypher key
 */

/* Cypher Key:
 * Lowercase: a = xay, b = pbq, c = gcx, d = ydm, e = fey, f = jfn, g = ggx, h = mhn, i = oih, j = rjd, k = wkz, l = klr, m = bmf,
              n = fnb, o = bog, p = mps, q = dqe, r = lrw, s = csd, t = bts, u = hut, v = cvp, w = fwh, x = dxm, y = ryc, z = bzo
 * Uppercase: A = fah, B = tbm, C = sce, D = bds, E = dep, F = tfp, G = sgr, H = mhs, I = gip, J = sjg, K = ukm, L = sld, M = kmu,
              N = zns, O = sop, P = tpf, Q = rqt, R = ira, S = lsp, T = gtp, U = mub, V = yvx, W = swa, X = mxz, Y = fyp, Z = czm
 * Numbers:
 * Special Characters:
 */
public class CypherTest {
    public static void main(String[] args) {

        Scanner menu = new Scanner(System.in);

        System.out.println("Would you like to encrypt a string, decrypt a string or, or see the encryption key?");
        System.out.println("1. Encrypt a string");
        System.out.println("2. Encrypt a string");
        System.out.println("3. View encryption key");

        String option = menu.nextLine();
        if (option.equals("1")) {
            System.out.println("Enter the text you want to encrypt:");
            Scanner textEncryptor = new Scanner(System.in);
            Encoder encode = new Encoder();
            String encrypt = textEncryptor.nextLine();
            encode.textEncoder(String.valueOf(encrypt));
        } /*
         * else if (option.equals("2")) {
         * Scanner decript = new Scanner(System.in);
         * }
         */ else if (option.equals("3")) {
            System.out.println("c. View encryption key");
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
}