package programs;

class TimeConvertionResult {

    public static String timeConversion(String s) {

        String convertedTimeAM = null,convertedTimePM=null;
        String[] timeSplit = s.split(":");
        if (s.contains("AM") && !timeSplit[0].equals("12")) {
            return s.replaceAll("AM","");
        }
        if(s.contains("AM") && timeSplit[0].equals("12")) {
            timeSplit[0] = "00";
            for (String time : timeSplit) {
                if(convertedTimeAM==null){
                    convertedTimeAM=time;
                    convertedTimeAM=convertedTimeAM.concat(":");
                }
                else if(time.contains("AM")){
                    convertedTimeAM=convertedTimeAM.concat(time.replaceAll("AM",""));
                }
                else{
                    convertedTimeAM = convertedTimeAM.concat(time + ":");
                }

            }
            return convertedTimeAM;
        }
        if(s.contains("PM") && timeSplit[0].equals("12")){
            return s.replaceAll("PM","");
        }
        if(s.contains("PM") && !timeSplit[0].equals("12"))
        {
            timeSplit[0] =String.valueOf(Integer.valueOf(timeSplit[0])+12);
            for (String time : timeSplit) {
                if(convertedTimePM==null){
                    convertedTimePM=time;
                    convertedTimePM=convertedTimePM.concat(":");
                }
                else if(time.contains("PM")){
                    convertedTimePM=convertedTimePM.concat(time.replaceAll("PM",""));
                }
                else{
                        convertedTimePM = convertedTimePM.concat(time + ":");
                }

            }
            return convertedTimePM;
        }
        return null;
    }
}
