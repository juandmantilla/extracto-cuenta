package co.com.porvenir.extracto_empresarial.adapters.out.pdf;

import co.com.porvenir.extracto_empresarial.application.exceptions.PorvenirException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JasperReportsAdapterTest {

    private JasperReportsAdapter adapter = new JasperReportsAdapter();

    @Test
    void generateReport_shouldThrowPorvenirException_whenLoadFails() throws Exception {
        try (
                MockedConstruction<ClassPathResource> mockResource = mockConstruction(ClassPathResource.class,
                        (mock, context) -> when(mock.getInputStream()).thenThrow(new IOException("IO error")));
                MockedStatic<JRLoader> loaderMock = mockStatic(JRLoader.class)
        ) {

            assertThrows(PorvenirException.class, () -> adapter.generateReport("invalidReport", Map.of()));

        }
    }

    @Test
    void getSubreport_shouldReturnJasperReport_whenValidSubreport() throws Exception {
        JasperReport mockReport = mock(JasperReport.class);
        InputStream dummyInputStream = new ByteArrayInputStream(new byte[]{});

        try (
                MockedConstruction<ClassPathResource> mockResource = mockConstruction(ClassPathResource.class,
                        (mock, context) -> when(mock.getInputStream()).thenReturn(dummyInputStream));
                MockedStatic<JRLoader> loaderMock = mockStatic(JRLoader.class)
        ) {
            loaderMock.when(() -> JRLoader.loadObject(dummyInputStream)).thenReturn(mockReport);

            JasperReport result = adapter.getSubreport("testSubreport");

            assertNotNull(result);
            assertSame(mockReport, result);
        }
    }

    @Test
    void getSubreport_shouldThrowPorvenirException_whenSubreportFails() throws Exception {
        try (
                MockedConstruction<ClassPathResource> mockResource = mockConstruction(ClassPathResource.class,
                        (mock, context) -> when(mock.getInputStream()).thenThrow(new IOException("file not found")));
                MockedStatic<JRLoader> loaderMock = mockStatic(JRLoader.class)
        ) {
            assertThrows(PorvenirException.class, () -> adapter.getSubreport("badSubreport"));

        }
    }

}