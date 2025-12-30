package christmas;

import christmas.controller.Controller;
import christmas.service.Service;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Service service = new Service();
        Controller controller = new Controller(inputView, outputView, service);

        controller.run();
    }
}

