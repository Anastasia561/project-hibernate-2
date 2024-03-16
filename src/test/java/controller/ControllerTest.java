package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.javarush.controller.Controller;
import ua.javarush.entity.Customer;
import ua.javarush.service.Service;
import ua.javarush.view.ConsoleViewProvider;

import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.ArgumentMatchers.anyString;

public class ControllerTest {
    private Service service;
    private ConsoleViewProvider consoleViewProvider;
    private Controller controller;

    @BeforeEach
    void init() {
        service = Mockito.mock(Service.class);
        consoleViewProvider = Mockito.mock(ConsoleViewProvider.class);
        controller = new Controller(service, consoleViewProvider);
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void processTestVerifyCreateCustomerMethodCallOnService() {
        Mockito.doReturn("1").when(consoleViewProvider).getMessage();
        controller.process();
        Mockito.verify(service, Mockito.atLeastOnce()).createCustomer(anyString(), anyString(),
                anyString(), anyString(), anyString(), anyString(), anyString());
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void processTestVerifyCreateFilmMethodCallOnService() {
        Mockito.doReturn("2").when(consoleViewProvider).getMessage();
        controller.process();
        Mockito.verify(service, Mockito.atLeastOnce()).createFilm("2", "2",
                "2", new String[]{"2"}, 2, 2, 2.0, 2.0);
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void processTestVerifyReturnAnyInventoryToStoreMethodCallOnService() {
        Mockito.doReturn("3").when(consoleViewProvider).getMessage();
        controller.process();
        Mockito.verify(service, Mockito.atLeastOnce()).returnAnyInventoryToStore();
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void processTestVerifyGetCustomerByIdMethodCallOnService() {
        Mockito.doReturn("4").when(consoleViewProvider).getMessage();
        controller.process();
        Mockito.verify(service, Mockito.atLeastOnce()).getCustomerById(anyShort());
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void processTestVerifyRentAnyAvailableFilmAndMakePaymentMethodCallOnService() {
        Mockito.doReturn("4").when(consoleViewProvider).getMessage();
        Mockito.doReturn(new Customer()).when(service).getCustomerById((short) 4);
        controller.process();
        Mockito.verify(service, Mockito.atLeastOnce()).rentAnyAvailableFilmAndMakePayment(new Customer());
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    void processTestForDefaultCase() {
        Mockito.doReturn("10").when(consoleViewProvider).getMessage();
        controller.process();
        Mockito.verify(consoleViewProvider, Mockito.atLeastOnce()).printMessage("incorrect option");
    }
}
