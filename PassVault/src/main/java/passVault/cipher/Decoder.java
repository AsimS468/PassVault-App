package passVault.cipher;

/* This Is the Decoder class for the code
 * This will check the characters in a given string to determine if the cypher key in the CypherKey class applies to that string
 * If the string can be fully decoded, it will return the result
 * if the string can not be fully decoded, then an Illegal Argument Exception will be thrown that states that will say "Text can not be decoded"
 */

/* Cypher Key:
 * Lowercase: a = xay, b = pbq, c = gcx, d = ydm, e = fey, f = jfn, g = ggx, h = mhn, i = oih, j = rjd, k = wkz, l = klr, m = bmf,
              n = fnb, o = bog, p = mps, q = dqe, r = lrw, s = csd, t = bts, u = hut, v = cvp, w = fwh, x = dxm, y = ryc, z = bzo
 * Uppercase: A = fah, B = tbm, C = sce, D = bds, E = dep, F = tfp, G = sgr, H = mhs, I = gip, J = sjg, K = ukm, L = sld, M = kmu,
              N = zns, O = sop, P = tpf, Q = rqt, R = ira, S = lsp, T = gtp, U = mub, V = yvx, W = swa, X = mxz, Y = fyp, Z = czm
 * Numbers:   0 = ppm, 1 = oon, 2 = iib, 3 = uuv, 4 = yyc, 5 = ttx, 6 = rrz, 8 = aap, 9 = sso
 * Special Characters:
 */

public class Decoder extends CypherKey {
    private String textToDecode;
    private String decodedText;

    public Decoder() {
        this.textToDecode = textToDecode;
        this.decodedText = decodedText;
    }

    public String textDecoder() {
        //Turns the characters in a given array into an array of chars
        char[] charsToDecode = this.textToDecode.toCharArray();
        //If statement to check to see if the length of the array is divisible by 3
        if(charsToDecode.length%3 != 0) {
            //Throws an illegal argument exception if the cypher is not divisible by 3
            throw new IllegalArgumentException("Error! Text can not be deciphered");
        }
        //Iterates through the characters of the array of chars until all the characters have been iterated through
        for(int i = 0; i <= charsToDecode.length; i++) {
            //Switches the characters in the array to its respective string in the HashMap in the CypherKey class

        }
        return null;
    }
}

