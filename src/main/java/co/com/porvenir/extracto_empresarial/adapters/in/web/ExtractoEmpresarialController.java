package co.com.porvenir.extracto_empresarial.adapters.in.web;

import co.com.porvenir.extracto_empresarial.adapters.in.web.dto.ExtractoEmpresarialRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extractoEmpresarial")
public class ExtractoEmpresarialController {


    @PostMapping("/generarReporte")
    public void generarExtractoEmpresarial(ExtractoEmpresarialRequestDto request) {

    }


}
