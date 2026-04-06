package hwss1602;

import hwss1501.DateTimeParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        ArrayList<Event> list = new ArrayList<>();
        while (true) {
            try {
                System.out.println("Nhập tên sự kiện (hoặc 'exit' để thoát):");
                String nameEvent = sc.nextLine();
                if (nameEvent.equals("exit")) {
                    break;
                }
                System.out.println("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm):");
                String startEvent = sc.nextLine();
                LocalDateTime startTime = LocalDateTime.parse(startEvent, dtf);
                System.out.println("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm):");
                String endEvent = sc.nextLine();
                LocalDateTime endTime = LocalDateTime.parse(endEvent, dtf);
                if (!startTime.isBefore(endTime)) {
                    throw new LocalDateTimeException("Start time must be before end time");
                }
                list.add(new Event(nameEvent, startTime, endTime));
            }
            catch (DateTimeParseException e) {
                System.out.println("Lỗi: Định dạng ngày tháng không đúng! (dd-MM-yyyy HH:mm)");
            }
            catch (LocalDateTimeException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Danh sách sự kiện:");
        for (Event event : list) {
            System.out.println(event.toString());
        }
    }
}
