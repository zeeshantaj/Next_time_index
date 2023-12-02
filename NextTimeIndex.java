  int nextTimeArrayIndex(String Finding, String[] fromArray) {
        if (Finding == null || Finding.length() < 5) {
            return -1; // Handle invalid input
        }

        int shortest = -1, shortestsec = -1;
        long minsecdif = (24 * 60 * 60 + 1), minsec = (24 * 60 * 60 + 1);
        int hr = Integer.parseInt(Finding.substring(0, 2));
        int min = Integer.parseInt(Finding.substring(3, 5));
        long seconds = convertToSec(hr, min, 0, Finding.substring(Finding.length() - 2));

        for (int i = 0; i < fromArray.length; i++) {
            if (fromArray[i] == null || fromArray[i].length() < 5) {
                continue; // Skip invalid entries
            }

            int temphr = Integer.parseInt(fromArray[i].substring(0, 2));
            int tempmin = Integer.parseInt(fromArray[i].substring(3, 5));
            String amOrPm = fromArray[i].substring(fromArray[i].length() - 2);
            long tempsec = convertToSec(temphr, tempmin, 0, amOrPm);
            if ((tempsec - seconds) > 0 && minsecdif > (tempsec - seconds)) {
                minsecdif = (tempsec - seconds);
                shortest = i;
            }
            if (minsec > tempsec) {
                minsec = tempsec;
                shortestsec = i;
            }
        }
        if (shortest >= 0) {
            return shortest;
        } else {
            return shortestsec;
        }
    }
