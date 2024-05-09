package passVault.cipher;
import java.util.HashMap;

/* This Is the CypherKey class for the code
 * This will be where the key for the cypher will be stored for the Encoder and Decoder classes to use
 */

/* Cypher Key:
 * Lowercase: a = xay, b = pbq, c = gcx, d = ydm, e = fey, f = jfn, g = ggx, h = mhn, i = oih, j = rjd, k = wkz, l = klr, m = bmf,
              n = fnb, o = bog, p = mps, q = dqe, r = lrw, s = csd, t = bts, u = hut, v = cvp, w = fwh, x = dxm, y = ryc, z = bzo
 * Uppercase: A = fah, B = tbm, C = sce, D = bds, E = dep, F = tfp, G = sgr, H = mhs, I = gip, J = sjg, K = ukm, L = sld, M = kmu,
              N = zns, O = sop, P = tpf, Q = rqt, R = ira, S = lsp, T = gtp, U = mub, V = yvx, W = swa, X = mxz, Y = fyp, Z = czm
 * Numbers:
 * Special Characters:
 */
public class CypherKey {
    protected static HashMap<Character, String> cypherValue = new HashMap<>();

    public CypherKey() {
        cypherValue = new HashMap<>();

        // Lowercase
        cypherValue.put('a', "xay");
        cypherValue.put('b', "pbq");
        cypherValue.put('c', "gcx");
        cypherValue.put('d', "ydm");
        cypherValue.put('e', "fey");
        cypherValue.put('f', "jfn");
        cypherValue.put('g', "ggx");
        cypherValue.put('h', "mhn");
        cypherValue.put('i', "oih");
        cypherValue.put('j', "rjd");
        cypherValue.put('k', "wkz");
        cypherValue.put('l', "klr");
        cypherValue.put('m', "bmf");
        cypherValue.put('n', "fnb");
        cypherValue.put('o', "bog");
        cypherValue.put('p', "mps");
        cypherValue.put('q', "dqe");
        cypherValue.put('r', "lrw");
        cypherValue.put('s', "csd");
        cypherValue.put('t', "bts");
        cypherValue.put('u', "hut");
        cypherValue.put('v', "cvp");
        cypherValue.put('w', "fwh");
        cypherValue.put('x', "dxm");
        cypherValue.put('y', "ryc");
        cypherValue.put('z', "bzo");

        // Uppercase
        cypherValue.put('A', "fah");
        cypherValue.put('B', "tbm");
        cypherValue.put('C', "sce");
        cypherValue.put('D', "bds");
        cypherValue.put('E', "dep");
        cypherValue.put('F', "tfp");
        cypherValue.put('G', "sgr");
        cypherValue.put('H', "mhs");
        cypherValue.put('I', "gip");
        cypherValue.put('J', "sjg");
        cypherValue.put('K', "ukm");
        cypherValue.put('L', "sld");
        cypherValue.put('M', "kmu");
        cypherValue.put('N', "zns");
        cypherValue.put('O', "sop");
        cypherValue.put('P', "tpf");
        cypherValue.put('Q', "rqt");
        cypherValue.put('R', "ira");
        cypherValue.put('S', "lsp");
        cypherValue.put('T', "gtp");
        cypherValue.put('U', "mub");
        cypherValue.put('V', "yvx");
        cypherValue.put('W', "swa");
        cypherValue.put('X', "mxz");
        cypherValue.put('Y', "fyp");
        cypherValue.put('Z', "czm");

        //special charactrs
        cypherValue.put('`', "f`h");
        cypherValue.put('~', "t~m");
        cypherValue.put('!', "s!e");
        cypherValue.put('@', "b@s");
        cypherValue.put('#', "d#p");
        cypherValue.put('$', "t$p");
        cypherValue.put('%', "s%r");
        cypherValue.put('^', "m^s");
        cypherValue.put('&', "g&p");
        cypherValue.put('*', "s*g");
        cypherValue.put('(', "u(m");
        cypherValue.put(')', "s)d");
        cypherValue.put('-', "k-u");
        cypherValue.put('_', "z_s");
        cypherValue.put('=', "s=p");
        cypherValue.put('+', "t+f");
        cypherValue.put('[', "r[t");
        cypherValue.put('{', "i{a");
        cypherValue.put(']', "l]p");
        cypherValue.put('}', "g}p");
        cypherValue.put('\\', "m\b");
        cypherValue.put('|', "y|x");
        cypherValue.put(';', "s;a");
        cypherValue.put(':', "m:z");
        cypherValue.put(' ', "f p");
        cypherValue.put('\'', "c'm");
        cypherValue.put('"', "y\"x");
        cypherValue.put(',', "s,a");
        cypherValue.put('<', "m<z");
        cypherValue.put('.', "f.p");
        cypherValue.put('>', "c>m");
        cypherValue.put('/', "y/x");
        cypherValue.put('?', "s?a");

        //numbers
        cypherValue.put('0', "u0m");
        cypherValue.put('1', "s1d");
        cypherValue.put('2', "k2u");
        cypherValue.put('3', "z3s");
        cypherValue.put('4', "s4p");
        cypherValue.put('5', "t5f");
        cypherValue.put('6', "r6t");
        cypherValue.put('7', "i7a");
        cypherValue.put('8', "l8p");
        cypherValue.put('9', "g9p");
    }


}