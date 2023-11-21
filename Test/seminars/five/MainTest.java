package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    RandomNumberModule randList;
    MaxNumberModule maxNumberModule;

    @BeforeEach
    void  setUp(){
        randList = new RandomNumberModule();
        maxNumberModule = new MaxNumberModule();
    }
    //5.1.
    @Test
    void testRandomGenerate(){
        List<Integer> result = randList.generate(6);

        assertThat(result.size()).isEqualTo(6);
    }
    @Test
    void testNumberTest(){
        List<Integer> testList = new ArrayList<>(Arrays.asList(15,25,49,55,95,10));
        int max = maxNumberModule.findmax(testList);
        assertThat(max).isEqualTo(95);
    }
    @Test
    void integrationTest(){
        List<Integer> result = randList.generate(6);

        assertThat(maxNumberModule.findmax(result)).isEqualTo(Collections.max(result));
    }

    //5.2.
    @Test
    void userServiceTest(){
        UserService userService = new UserService((new UserRepository()));

        String user = userService.getUserName(0);

        assertEquals("User 0", user);
    }
    //5.3.
    @Test
    void testOrderServiceIntegration(){
        OrderService orderService = new OrderService(new PaymentService());

        boolean res = orderService.placeOrder("1232", 12000);

        assertTrue(res);
    }
}