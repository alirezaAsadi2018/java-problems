package ir.javacup.traffic.impl;

import ir.javacup.traffic.Transformer;

import java.util.Base64;

public class TrafficInfoTransformer implements Transformer<TrafficInfo,String> {
    @Override
    public TrafficInfo transform(String input) {
        Base64.Decoder decoder = Base64.getDecoder();
        String decodedString = new String(decoder.decode(input));
        if(!decodedString.contains(","))
            throw new IllegalArgumentException(
                    "Decode input string doesn't contain any commas!");
        String[] split = decodedString.split(",");
        TrafficInfo trafficInfo = new TrafficInfo();
        trafficInfo.setLocationCode(split[0]);
        trafficInfo.setTrafficLevel(Integer.parseInt(split[1]));
        return trafficInfo;
    }
}
