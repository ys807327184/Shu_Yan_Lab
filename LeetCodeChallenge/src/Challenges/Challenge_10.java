package Challenges;

public class Challenge_10 {
	//Version 1 Java did it for me
	/*
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		return s.matches(p);
	}
	*/
	public boolean isMatch(String s, String p) {
		int is = s.length() - 1;
		int ip = p.length() - 1;
		return recursion(s, p, is, ip);
	}
	
	public boolean recursion(String s, String p, int is, int ip) {
		while (is >= -1 && ip >= 0) {
			if (p.charAt(ip) != '*') {
				if (is == -1 || p.charAt(ip) != '.' && p.charAt(ip) != s.charAt(is)) {
					return false;
				}
				is--;
				ip--;
			} else {
				if (recursion(s, p, is, ip - 2)) {
					return true;
				}
				if (is == -1 || p.charAt(ip - 1) != '.' && s.charAt(is) != p.charAt(ip - 1)) {
					return false;
				}
				return recursion(s, p, is - 1, ip);
			}
		}
		if (is == -1 && ip == -1) {
			return true;
		} else {
			return false;
		}
	}
}
