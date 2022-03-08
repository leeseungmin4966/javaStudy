package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TravelTest {

    public static void main(String[] args) {
        TravelCustomer customerLee = new TravelCustomer("이순신", 40, 100);
        TravelCustomer customerKim = new TravelCustomer("김유신", 20, 100);
        TravelCustomer customerHong = new TravelCustomer("홍길동", 13, 50);

        List<TravelCustomer> customerList = new ArrayList<>();
        customerList.add(customerLee);
        customerList.add(customerKim);
        customerList.add(customerHong);

        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));

        int total = customerList.stream().mapToInt(customer -> customer.getPrice()).sum();
        System.out.println("총 여행 비용은 :" + total + "입니다");

        System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
        List<String> customerNameList = customerList.stream().filter(customer -> customer.getAge()>= 20).map(customer -> customer.getName()).collect(Collectors.toList());
        System.out.println(customerNameList);
    }

}
