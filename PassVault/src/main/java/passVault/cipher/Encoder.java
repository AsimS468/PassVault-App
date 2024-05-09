package passVault.cipher;

/* This Is the Encoder class for the code
 * This will use the data from the CypherKey class to change each character in a given string to its corresponding mapped string and print out the encoded result
 */

/* Cypher Key:
 * Lowercase: a = xay, b = pbq, c = gcx, d = ydm, e = fey, f = jfn, g = ggx, h = mhn, i = oih, j = rjd, k = wkz, l = klr, m = bmf,
              n = fnb, o = bog, p = mps, q = dqe, r = lrw, s = csd, t = bts, u = hut, v = cvp, w = fwh, x = dxm, y = ryc, z = bzo
 * Uppercase: A = fah, B = tbm, C = sce, D = bds, E = dep, F = tfp, G = sgr, H = mhs, I = gip, J = sjg, K = ukm, L = sld, M = kmu,
              N = zns, O = sop, P = tpf, Q = rqt, R = ira, S = lsp, T = gtp, U = mub, V = yvx, W = swa, X = mxz, Y = fyp, Z = czm
 * Numbers:
 * Special Characters:
 */

public class Encoder extends CypherKey {

    private String textToEncode;
    private String encodedText;

    public Encoder() {
        this.textToEncode = textToEncode;
        this.encodedText = encodedText;
    }

    public String textEncoder(String textToEncode) {
        //StringBuilder sb = new StringBuilder();

        // Turns the characters in a given array into an array of chars
        char[] charsToEncode = textToEncode.toCharArray();

        // Iterates through the characters of the array of chars until all the
        // characters have been iterated through
        for (char inputChar : charsToEncode) {

            // Switches the characters in the array to its respective string in the HashMap
            this.encodedText = CypherKey.cypherValue.get(inputChar);
            System.out.print(encodedText);
        }
        return encodedText;
    }
}