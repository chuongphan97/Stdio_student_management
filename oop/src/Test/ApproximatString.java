/*
package Test;

private class ApproximatString {
    String s;
    int i, j, k, loi, saiSo;
    public ApproximatString(String nhap) {
        s = nhap;
        saiSo = (int) Math.round(s.length() * 0.3);
    }
    public boolean soSanh(String s1) {
        if (s1.length() < (s.length() - saiSo) || s1.length() > (s.length() + saiSo))

                loi++;
                for (int l = 0; l < saiSo; l++) {
                    if ((i + l < s.length())) {
                        i+=l;
                        break;
                    } else if ((j + l < s1.length()) && s.charAt(i) == s.charAt(j+l)) {
                        j += l;
                        break;
                    }
                }
            }
            i++;
            j++;

        }
        loi += s.length() - i + s1.length() - j;
        if(loi < saiSo)
            return false;
        else return true;
    }
}
*/
