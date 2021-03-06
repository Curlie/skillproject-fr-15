package alexasescape.handlers;

import alexasescape.constants.SpeechText;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class HelpIntentHandlerTest {

    private HelpIntentHandler handler;

    @Before
    public void setup(){
        handler = new HelpIntentHandler();
    }

    @Test
    public void canHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void handle() {
        final Response response = TestUtil.standardTestForHandle(handler);
        assertTrue(response.getOutputSpeech().toString().contains(SpeechText.HELP));

    }
}