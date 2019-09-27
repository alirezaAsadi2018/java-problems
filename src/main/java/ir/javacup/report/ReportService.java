package ir.javacup.report;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReportService {
    private InformationRepository repository;

    public ReportService(InformationRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        ReportService service = new ReportService(new InformationRepository() {
            @Override
            public List<Information> fetchAll() {
                return Arrays.asList(
                        new Information("Kerman", "1395/03/11", 62L), new Information("Tehran", "1395/09/12", 90L),
                        new Information("Tehran", "1396/11/30", 31L), new Information("Semnan", "1396/01/13", 93L)
                );
            }
        });

        List<CityInformation> sumResults = service.sumByCity(1396);
        System.out.printf("sum total: %d%n", sumResults.size());
        CityInformation sumFirst = sumResults.get(0);
        System.out.printf("1: %s %d%n", sumFirst.getCity(), sumFirst.getSum());
        CityInformation sumSecond = sumResults.get(1);
        System.out.printf("2: %s %d%n", sumSecond.getCity(), sumSecond.getSum());

        List<CityMonthInformation> avgResults = service.averageByCityAndMonth(1395);
        System.out.printf("avg total: %d%n", avgResults.size());
        CityMonthInformation avgFirst = avgResults.get(0);
        System.out.printf("1: %s %d %f%n", avgFirst.getCity(), avgFirst.getMonth(), avgFirst.getAverage());
        CityMonthInformation avgSecond = avgResults.get(1);
        System.out.printf("2: %s %d %f%n", avgSecond.getCity(), avgSecond.getMonth(), avgSecond.getAverage());
    }

    public List<CityInformation> sumByCity(int year) {
        Map<String, Long> map = repository.fetchAll().stream()
                .filter(i -> i.getDate().contains(String.valueOf(year)))
                .collect(Collectors.toMap(Information::getCity
                        , Information::getAmount
                        , (one, two) -> one + two, TreeMap::new)
                );
        List<CityInformation> list = new LinkedList<>();
        for (String city : map.keySet()) {
            CityInformation cityInformation = new CityInformation();
            cityInformation.setCity(city);
            cityInformation.setSum(map.get(city));
            list.add(cityInformation);
        }
        return list;
    }

    public List<CityMonthInformation> averageByCityAndMonth(int year) {
        class Pair{
            String month;
            String city;


            public String getMonth() {
                return month;
            }

            public String getCity() {
                return city;
            }

            public Pair(String city, String date) {
                this.city = city;
                month = date.split("/")[1];
            }
        }
        Map<Pair, Long> map = repository.fetchAll().stream()
                .filter(i -> i.getDate().contains(String.valueOf(year)))
                .collect(Collectors.toMap((Information i) -> new Pair(i.getCity(), i.getDate())
                        , Information::getAmount
                        , (one, two) -> one + two
                        , ()->new TreeMap<>(Comparator.comparing(Pair::getCity)
                                .thenComparing(Pair::getMonth)))
                );
        List<CityMonthInformation> list = new LinkedList<>();
        for (Pair pair : map.keySet()) {
            CityMonthInformation cityMonthInformation = new CityMonthInformation();
            cityMonthInformation.setCity(pair.city);
            cityMonthInformation.setMonth(Integer.parseInt(pair.month));
            double avg = cityMonthInformation.getMonth() <= 6 ? (double)map.get(pair) / 31.0
                    : (double)map.get(pair) / 30.0;
            cityMonthInformation.setAverage(avg);
            list.add(cityMonthInformation);
        }
        return list;
    }

}
