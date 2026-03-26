package banking;

public final class ProtocolKeamanan {

    public final String ID_SERVER;
    private final String privateKey;
    private final String publicKey;

    public ProtocolKeamanan() {
        this.ID_SERVER = "GMR-SERVER-001";
        this.privateKey = "PRV-947362";
        this.publicKey = "PUB-562184";
    }

    public ProtocolKeamanan(String idServer, String privateKey, String publicKey) {
        this.ID_SERVER = idServer;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public boolean validasiTransaksi(Transaksi t) {
        if (t == null) {
            return false;
        }
        boolean jenisValid = t.getJenisTransaksi() != null && !t.getJenisTransaksi().trim().isEmpty();
        return t.validasi() && jenisValid;
    }

    public String enkripsiData(String data) {
        if (data == null) {
            return "";
        }
        String gabungan = data + "|" + publicKey;
        char[] arr = gabungan.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] + 3);
        }
        return new String(arr);
    }

    public String deskripsiData(String data) {
        if (data == null) {
            return "";
        }
        char[] arr = data.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] - 3);
        }
        String decoded = new String(arr);

        int separator = decoded.lastIndexOf("|");
        if (separator >= 0) {
            return decoded.substring(0, separator);
        }
        return decoded;
    }

    public String generateToken() {
        long now = System.currentTimeMillis();
        String raw = ID_SERVER + "-" + now + "-" + privateKey.length();
        return enkripsiData(raw);
    }

    public boolean verifikasiPin(String pin) {
        if (pin == null || pin.length() != 6) {
            return false;
        }
        for (int i = 0; i < pin.length(); i++) {
            char c = pin.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }

        String suffix = privateKey;
        if (suffix.length() >= 4) {
            suffix = suffix.substring(suffix.length() - 4);
        }

        String expected = "";
        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            if (c >= '0' && c <= '9') {
                expected += c;
            }
        }

        if (expected.length() < 4) {
            expected = "0000";
        }

        return pin.endsWith(expected);
    }

    public String getPrivateKeyMasked() {
        return "********";
    }

    public String getPublicKey() {
        return publicKey;
    }
}
