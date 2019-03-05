import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCalculatorShould {
    private StringCalculatorProvider stringCalculator;

    @Before
    public void before() {
        stringCalculator = new StringCalculatorProvider();
    }

    @Test
    public void return_0() {
        assertThat(stringCalculator.add(""), is(0));
    }

    @Test
    public void return_1() {
        assertThat(stringCalculator.add("1"), is(1));
    }

    @Test
    public void return_2() {
        assertThat(stringCalculator.add("2"), is(2));
    }

    @Test
    public void return_3() {
        assertThat(stringCalculator.add("1,2"), is(3));
    }

    @Test
    public void return_4() {
        assertThat(stringCalculator.add("2,2"), is(4));
    }

    @Test
    public void return_27() {
        assertThat(stringCalculator.add("20,7"), is(27));
    }

    @Test
    public void return_53() {
        assertThat(stringCalculator.add("40,13"), is(53));
    }

    @Test
    public void return_99() {
        assertThat(stringCalculator.add("33,33,33"), is(99));
    }

    @Test
    public void return_55() {
        assertThat(stringCalculator.add("1,2,3,4,5,6,7,8,9,10"), is(55));
    }

    @Test
    public void return_6() {
        assertThat(stringCalculator.add("1\n2,3"), is(6));
    }

    @Test
    public void return_3_with_custom_delimiter() {
        assertThat(stringCalculator.add("//;\n1;2"), is(3));
    }

    @Test
    public void return_3_with_custom_delimiter_2() {
        assertThat(stringCalculator.add("//'\n1'2"), is(3));
    }

    @Test
    public void return_3_with_custom_delimiter_3() {
        assertThat(stringCalculator.add("//z\n1z2"), is(3));
    }

    //Calling Add with a negative number will throw an
    //exception “negatives not allowed” -
    //and the negative that was passed.if there are multiple negatives,
    //show all of them in the exception message

    @Test(expected = StringCalculatorProvider.NegativesNumbersException.class)
    public void throw_exception_negatives_not_allowed() {
        stringCalculator.add("-1");
    }

//    @Test(expected = StringCalculatorProvider.NegativesNumbersException.class)
//    public void throw_exception_negatives_not_allowed() {
//        stringCalculator.add("-1");
//    }
}
