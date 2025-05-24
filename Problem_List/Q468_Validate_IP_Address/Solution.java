package Problem_List.Q468_Validate_IP_Address;

class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;
            if (part.charAt(0) == '0' && part.length() > 1) return false; // ведучі нулі
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            int num = 0;
            try {
                num = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                return false;
            }
            if (num < 0 || num > 255) return false;
        }
        return true;
    }

    private boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;
            for (char c : part.toCharArray()) {
                if (!isHexChar(c)) return false;
            }
        }
        return true;
    }

    private boolean isHexChar(char c) {
        return (c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'f') ||
                (c >= 'A' && c <= 'F');
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Результат 1: " + sol.validIPAddress("172.16.254.1")); // IPv4
        System.out.println("Результат 2: " + sol.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
        System.out.println("Результат 3: " + sol.validIPAddress("256.256.256.256")); // Neither
    }
}

