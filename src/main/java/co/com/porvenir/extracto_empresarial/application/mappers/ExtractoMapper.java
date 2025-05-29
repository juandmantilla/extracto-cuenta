package co.com.porvenir.extracto_empresarial.application.mappers;

import co.com.porvenir.extracto_empresarial.application.dto.models.*;
import co.com.porvenir.extracto_empresarial.application.dto.models.extract.*;

import java.util.ArrayList;
import java.util.List;

public class ExtractoMapper {

    public static ExtractoEmpresarialReportDTO mapper(Extracto extracto) {

        var extractoMapped = new ExtractoEmpresarialReportDTO();

        buildHeadParams(extractoMapped, extracto);
        buildIggeParams(extractoMapped, extracto);
        buildIdeParams(extractoMapped, extracto);
        buildMpaParams(extractoMapped, extracto);

        return extractoMapped;

    }

    private static void buildHeadParams(ExtractoEmpresarialReportDTO extractoMapped, Extracto extracto) {
        extractoMapped.setPeriodo(extracto.getEncabezadoPag().getPeriodo().getFechaInicial());
        extractoMapped.setNumeroExtracto(extracto.getEncabezadoPag().getConsecutivo());
        extractoMapped.setFechaExpedicion(extracto.getEncabezadoPag().getFechaEmision());
    }

    private static void buildIggeParams(ExtractoEmpresarialReportDTO extractoMapped, Extracto extracto) {

        extractoMapped.setIggeNitPlan(extracto.getEncabezado().getNit());
        extractoMapped.setIggeDireccion(extracto.getEncabezado().getDireccion());
        extractoMapped.setIggeNic(extracto.getEncabezado().getNic());
        extractoMapped.setIggeEntidadPatrocinadora(extracto.getEncabezado().getRazonSocial());
        extractoMapped.setIggeCiudadDepto(extracto.getEncabezado().getCiudad());
        extractoMapped.setIggeNitEmpresarial(extracto.getEncabezado().getNit());
        extractoMapped.setIggeTable(buildIggeList(extracto));

        buildIggTotalTable(extractoMapped, extracto);
    }

    private static List<IggeTableDTO> buildIggeList(Extracto extracto) {

        var listTable = new ArrayList<IggeTableDTO>();
        var listObjetivos = extracto.getInformacionGrupoEmpresarial().getObjetivos().getObjetivo();

        for (Objetivo element : listObjetivos) {

            var iggeElement = new IggeTableDTO();
            iggeElement.setObjetivoPlanEmpresarial(element.getDescripcion());
            iggeElement.setSaldoAnterior(element.getSaldoAnterior());
            iggeElement.setAportes(element.getAportes());
            iggeElement.setRetiros(element.getRetiros());
            iggeElement.setTrasladoEntreObjetivos(element.getTransferencias());
            iggeElement.setValorizacion(element.getValorizacion());
            iggeElement.setSaldoFinal(element.getSaldoFinal());
            iggeElement.setSaldoRestringido(element.getSaldoRestringido());
            iggeElement.setComisionCobrada(element.getComision());

            listTable.add(iggeElement);
        }

        return listTable;
    }

    private static void buildIggTotalTable(ExtractoEmpresarialReportDTO extractoMapper, Extracto extracto) {

        var infEmpresarial = extracto.getInformacionGrupoEmpresarial();
        var totalAlternativas = infEmpresarial.getAlternativasGrupoEmpre().getAlternativas().getTotalAlternativas();

        extractoMapper.setIggeTotalSaldoAnterior(totalAlternativas.getSaldoAnterior());
        extractoMapper.setIggeTotalAportes(totalAlternativas.getAportes());
        extractoMapper.setIggeTotalRetiros(totalAlternativas.getRetiros());
        extractoMapper.setIggeTotalTraslados(totalAlternativas.getTransferencias());
        extractoMapper.setIggeTotalValorizacion(totalAlternativas.getValorizacion());
        extractoMapper.setIggeTotalSaldoFinal(totalAlternativas.getSaldoFinal());
        extractoMapper.setIggeTotalSaldoRestringido(totalAlternativas.getSaldoRestringido());
        extractoMapper.setIggeTotalComisionCobrada(totalAlternativas.getComision());
        extractoMapper.setIggeNumeroParticipes(infEmpresarial.getTotalAfiliados());
    }


    private static void buildIdeParams(ExtractoEmpresarialReportDTO extractoMapper, Extracto extracto) {
        extractoMapper.setIdeTable(buildIdeTable(extracto));
        buildIdeTotalTable(extractoMapper, extracto);
    }

    private static List<IdeTableDTO> buildIdeTable(Extracto extracto) {

        var listIdeTable = new ArrayList<IdeTableDTO>();
        var altGrupoEmp = extracto.getInformacionGrupoEmpresarial().getAlternativasGrupoEmpre();
        var listAlter = altGrupoEmp.getAlternativas().getAlternativa();

        for (Alternativa element : listAlter) {

            var ideElement = new IdeTableDTO();
            var altInversion = element.getAlternativaInversion();

            ideElement.setPortafolioInversion(element.getDescripcion());
            ideElement.setSaldoAnterior(element.getSaldoAnterior());
            ideElement.setAportes(element.getAportes());
            ideElement.setRetiros(element.getRetiros());
            ideElement.setTrasladosEntrePortafolios(element.getTransferencias());
            ideElement.setValorizacion(element.getValorizacion());
            ideElement.setSaldoFinal(element.getSaldoFinal());
            ideElement.setSaldoRestringido(element.getSaldoRestringido());
            ideElement.setComisionCobrada(element.getComision());
            ideElement.setRentPeriodoPlan(altInversion.getRentabilidadPeriodoAfiliado());
            ideElement.setRentPeriodoFondo(altInversion.getRentabilidadPeriodoFondo());
            ideElement.setRentAcumuladaFondo(altInversion.getRentabilidadAcumuladaFondo());

            listIdeTable.add(ideElement);
        }

        return listIdeTable;

    }

    private static void buildIdeTotalTable(ExtractoEmpresarialReportDTO extractoMapper, Extracto extracto) {

        var altGrupEmp = extracto.getInformacionGrupoEmpresarial().getAlternativasGrupoEmpre();
        var totalObjetivos = altGrupEmp.getAlternativas().getTotalAlternativas();

        extractoMapper.setIdeSaldoAnterior(totalObjetivos.getSaldoAnterior());
        extractoMapper.setIdeAportes(totalObjetivos.getAportes());
        extractoMapper.setIdeRetiros(totalObjetivos.getRetiros());
        extractoMapper.setIdeTrasladosPortafolios(totalObjetivos.getTransferencias());
        extractoMapper.setIdeValorizacion(totalObjetivos.getValorizacion());
        extractoMapper.setIdeSaldoFinal(totalObjetivos.getSaldoFinal());
        extractoMapper.setIdeSaldoRestringido(totalObjetivos.getSaldoRestringido());
        extractoMapper.setIdeComisionCobrada(totalObjetivos.getComision());
        extractoMapper.setIdePlan(totalObjetivos.getRentabilidadPeriodoPlan());
        extractoMapper.setIdeFondo(null); // TODO : Revisar este parámetro
        extractoMapper.setIdeRentaAcumulada(null); // TODO : Revisar este parámetro

    }

    private static void buildMpaParams(ExtractoEmpresarialReportDTO extractoMapper, Extracto extracto) {

        var montoProcAcr = extracto.getMontoenProcAcr();
        var totalMontos = extracto.getTotalMontos();
        var detalleCondicionList = extracto.getCondicionesPlan().getDetalleCondicion();

        extractoMapper.setMpaNit(montoProcAcr.getNit());
        extractoMapper.setMpaMontoProceso(montoProcAcr.getMontoEnProceso());
        extractoMapper.setMpaNitTotal(totalMontos.getNit());
        extractoMapper.setMpaMontoProceso(totalMontos.getMontoEnProceso());
        extractoMapper.setMpaTable(buildMpaTable(detalleCondicionList));
    }

    private static List<MpaTableDTO> buildMpaTable(List<DetalleCondicion> detalleCondicionList) {

        var mpaTableList = new ArrayList<MpaTableDTO>();

        for (DetalleCondicion element : detalleCondicionList) {

            var mpaElement = new MpaTableDTO();
            var tipoAporte = element.getTipoAportes();
            var realizaAporte = tipoAporte.getRealizaAporte();
            var aporCondicion = tipoAporte.getAporteTieneCondicion();
            var tipoValor = tipoAporte.getMontoAporte();
            var periodicidad = tipoAporte.getPeriocidadAporte();
            var permiteRetiros = tipoAporte.getPermiteRetiroAporte();
            var reqAuto = tipoAporte.getRequiereAutorizacionAporte();
            var perTrasPorta = tipoAporte.getPermiteTraladoAporte();
            var perBloqEntidades = tipoAporte.getPermiteBloqueoAporte();

            mpaElement.setCodigoObjetivo(element.getCodigoDelObjetivo());
            mpaElement.setNombreObjetivo(element.getNombreDelObjetivo());
            mpaElement.setTipoAporte(tipoAporte.getTipoAporteAfiliado());
            mpaElement.setRealizaAporte(realizaAporte.getRealizaAporteAfiliado());
            mpaElement.setAporteTieneCondicion(aporCondicion.getCondicionAporteAfiliado());
            mpaElement.setMontAporteTipoValor(tipoValor.getMontoAporteTipoValAfiliado());
            mpaElement.setMontAporteTipoValor(tipoValor.getMontoAporteValorAfiliado());
            mpaElement.setPeriodicidad(periodicidad.getPeriocidadAporteAfiliado());
            mpaElement.setPermiteRetiros(permiteRetiros.getPermiteRetiroAporteAfiliado());
            mpaElement.setReqAutorizacionRetiros(reqAuto.getRequiereAutorizacionAfiliado());
            mpaElement.setPermiteTrasladoPortafolios(perTrasPorta.getPermiteTraladoAporteAfiliado());
            mpaElement.setPermiteBloqueoEntidades(perBloqEntidades.getPermiteBloqueoAporteAfiliado());

            mpaTableList.add(mpaElement);
        }
        return mpaTableList;
    }

    private static void buildRmpTable(ExtractoEmpresarialReportDTO extractoMapper, Extracto extracto) {

        var saldoAfiliadoList = extracto.getTotalSaldosAfiliados().getSaldoAfiliado();

        var rmpList = new ArrayList<RmpTableDTO>();

        for (SaldoAfiliado element : saldoAfiliadoList) {

            var rmpElement = new RmpTableDTO();

            rmpElement.setCuentaNumero(element.getIdCuentaPlan());
            rmpElement.setNombreParticipe(element.getNombreAfiliado());
            rmpElement.setObjetivo(element.getCodObjetivo());
            rmpElement.setSaldoInicial(element.getSaldoAnterior());
            rmpElement.setAportes(element.getAportes());
            rmpElement.setRetiros(element.getRetiros());
            rmpElement.setTrasladosObjetivos(element.getTransferencias());
            rmpElement.setSaldoFinal(element.getSaldoFinal());

            rmpList.add(rmpElement);
        }

        extractoMapper.setRmpTable(rmpList);
    }

}
