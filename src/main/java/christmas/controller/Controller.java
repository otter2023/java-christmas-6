package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.service.Service;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Controller {

    private final Service service;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.init();
        int date = readDate();
        Map<Menu, Integer> menu = readMenu();

        Order order = service.makeOrder(date, menu);

        outputView.printOrder(order, date);
    }

    private int readDate() {
        while (true) {
            try {
                return inputView.readDate();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<Menu, Integer> readMenu() {
        while (true) {
            try {
                return inputView.readMenu();
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
