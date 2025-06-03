package co.com.porvenir.extracto_empresarial.application.mappers;

import co.com.porvenir.extracto_empresarial.application.dto.models.extract.Extracto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExtractoMapperTest {


    @Test
    void mapperTest() throws JsonProcessingException {

        var mapper = new ObjectMapper();
        String extractObject = """
                	{
                		"EncabezadoPag": {
                			"Periodo": {
                				"FechaInicial": "Octubre 01 de 2024 - Diciembre 31 de 2024"
                			},
                			"Consecutivo": "PI - 739",
                			"FechaEmision": "Enero 28 de 2025",
                			"TextoFechaInicial": "A 01 de Octubre de 2024",
                			"TextoFechaMedio": "Entre Octubre y Diciembre de 2024",
                			"TextoFechaFinal": "A 31 de Diciembre de 2024"
                		},
                		"Encabezado": {
                			"TipoId": "NIT",
                			"NIT": "800251163 / 1967",
                			"RazonSocial": "OLEODUCTO CENTRAL S.A.",
                			"NIC": "578709",
                			"Ciudad": "BOGOTÃ D.C. / BOGOTA",
                			"Direccion": "CR 11 84 09 PS 10",
                			"CorreoEmpresa": "nomina@ocensa.com.co"
                		},
                		"Pie": {
                			"ConsultorAsignado": "PIRAQUIVE LEON DANIEL ALBERTO",
                			"CelularConsultor": "3152594167",
                			"Ciudad": "BOGOTÃ D.C.",
                			"CorreoConsultor": "dapiraquive@porvenir.com.co"
                		},
                		"CondicionesPlan": {
                			"NombrePlan": "OLEODUCTO CENTRAL S.A.",
                			"DetalleCondicion": [
                				{
                					"CodigoDelObjetivo": "71",
                					"NombreDelObjetivo": "AHORRO PARTICIPE",
                					"TipoAportes": {
                						"TipoAporteAfiliado": "Afiliado",
                						"TipoAporteEmpleador": "Empleador",
                						"RealizaAporte": {
                							"RealizaAporteAfiliado": "SI",
                							"RealizaAporteEmpleador": "NO"
                						},
                						"AporteTieneCondicion": {
                							"CondicionAporteAfiliado": "N/A",
                							"CondicionAporteEmpleador": "NO"
                						},
                						"MontoAporte": {
                							"MontoAporteTipoValAfiliado": "%",
                							"MontoAporteTipoValEmpleador": "$",
                							"MontoAporteValorAfiliado": "1",
                							"MontoAporteValorEmpleador": "0"
                						},
                						"PeriocidadAporte": {
                							"PeriocidadAporteAfiliado": "MENSUAL",
                							"PeriocidadAporteEmpleador": "UNICO"
                						},
                						"PermiteRetiroAporte": {
                							"PermiteRetiroAporteAfiliado": "SI",
                							"PermiteRetiroAporteEmpleador": "NO"
                						},
                						"RequiereAutorizacionAporte": {
                							"RequiereAutorizacionAfiliado": "SI",
                							"RequiereAutorizacionEmpleador": "NO"
                						},
                						"PermiteTraladoAporte": {
                							"PermiteTraladoAporteAfiliado": "SI",
                							"PermiteTraladoAporteEmpleador": "SI"
                						},
                						"PermiteBloqueoAporte": {
                							"PermiteBloqueoAporteAfiliado": "NO",
                							"PermiteBloqueoAporteEmpleador": "NO"
                						}
                					}
                				}
                			]
                		},
                		"Rentabilidades": {
                			"Rentabilidad90DiasAfiliado": "8.27% Efectivo Anual",
                			"Rentabilidad365DiasAfiliado": "9.85% Efectivo Anual"
                		},
                		"Comisiones": {
                			"Comision90DiasAfiliado": "1.21% sobre el total de activos administrados",
                			"Comision365DiasAfiliado": "1.28% sobre el total de activos administrados",
                			"ComisionPesos90DiasAfiliado": "$28,958,639",
                			"ComisionPesos365DiasAfiliado": "$112,309,692"
                		},
                		"InformacionDesagregadaGrupoEmpresarial": "",
                		"InformacionGrupoEmpresarial": {
                			"NIT": "800251163",
                			"TOTALAFILIADOS": "227",
                			"TOTALAFILIADOSACT": "224",
                			"TOTALAFILIADOSPRE": "0",
                			"Objetivos": {
                				"Objetivo": [
                					{
                						"Descripcion": "AHORRO PARTICIPE",
                						"SaldoAnterior": "$762,869,431",
                						"Aportes": "$0",
                						"Retiros": "$0",
                						"Devoluciones": "$0",
                						"Distribucion": "$0",
                						"Transferencias": "-$5,448,015",
                						"Valorizacion": "$16,464,367",
                						"SaldoFinal": "$773,885,783",
                						"SaldoRestringido": "$0",
                						"Comision": "$1,022,638"
                					}
                				]
                			},
                			"AlternativasGrupoEmpre": {
                				"Alternativas": {
                					"Alternativa": [
                						{
                							"Descripcion": "Efectivo Colombia Pesos",
                							"SaldoAnterior": "$2,411,457,224",
                							"Aportes": "$169,307,038",
                							"Retiros": "$91,630,377",
                							"Transferencias": "-$519,954",
                							"Valorizacion": "$44,642,406",
                							"SaldoFinal": "$2,533,256,337",
                							"SaldoRestringido": "$17,570,090",
                							"Comision": "$10,872,302",
                							"AlternativaInversion": {
                								"RentabilidadPeriodoAfiliado": "7.08",
                								"RentabilidadPeriodoFondo": "7.45",
                								"RentabilidadAcumuladaFondo": "9.6"
                							}
                						},
                						{
                							"Descripcion": "Diversificado Conservador",
                							"SaldoAnterior": "$179,339,073",
                							"Aportes": "$0",
                							"Retiros": "$0",
                							"Transferencias": "$0",
                							"Valorizacion": "$2,102,542",
                							"SaldoFinal": "$181,441,615",
                							"SaldoRestringido": "$0",
                							"Comision": "$1,136,577",
                							"AlternativaInversion": {
                								"RentabilidadPeriodoAfiliado": "4.73",
                								"RentabilidadPeriodoFondo": "4.73",
                								"RentabilidadAcumuladaFondo": "8.66"
                							}
                						}
                					],
                					"TotalAlternativas": {
                						"SaldoAnterior": "$7,828,946,607",
                						"Aportes": "$239,859,647",
                						"Retiros": "$91,630,377",
                						"Transferencias": "-$177,700,828",
                						"Valorizacion": "$160,625,283",
                						"SaldoFinal": "$7,960,100,332",
                						"SaldoRestringido": "$4,268,747,661",
                						"Comision": "$19,230,201",
                						"RentabilidadPeriodoPlan": "8.27"
                					}
                				}
                			},
                			"TotalObjetivos": {
                				"SaldoAnterior": "$7,828,946,607",
                				"Aportes": "$239,859,647",
                				"Retiros": "$91,630,377",
                				"Devoluciones": "$0",
                				"Distribucion": "$0",
                				"Transferencias": "-$177,700,828",
                				"Valorizacion": "$160,625,283",
                				"SaldoFinal": "$7,960,100,332",
                				"SaldoRestringido": "$4,268,747,661",
                				"Comision": "$19,230,201"
                			}
                		},
                		"GraficoDinamico": {
                			"Nombre": "extractope1967_0310",
                			"Formato": "jpg",
                			"Tipo": "PIE",
                			"Alto": "170",
                			"Ancho": "170",
                			"GrosorBorde": "0",
                			"Dato": [
                				{
                					"X": "Efectivo Colombia Pesos",
                					"Y": ".32",
                					"Color": "75,113,29"
                				},
                				{
                					"X": "Diversificado Conservador",
                					"Y": ".02",
                					"Color": "178,187,30"
                				}
                			]
                		},
                		"RentabilidadInicio": "6.24",
                		"RentabilidadPeriodo": "9.18",
                		"MontoenProcAcr": {
                			"NIT": "800251163",
                			"MontoEnProceso": "$.00",
                			"RezagosCorrientes": "$.00",
                			"RezagosHistoricos": "$483,646.00",
                			"SaldoFinalMasMontoEnProceso": "$310,341,350.18"
                		},
                		"TotalMontos": {
                			"NIT": "44",
                			"MontoEnProceso": "$.00",
                			"RezagosCorrientes": "$.00",
                			"RezagosHistoricos": "$483,646.00"
                		},
                		"TotalSaldosAfiliados": {
                			"SaldoAfiliado": [
                				{
                					"IDCuentaPlan": "102433",
                					"EstadoCuenta": "A",
                					"NombreAfiliado": "TAMAYO FLOREZ MARIA FERNANDA",
                					"DocAfiliado": "51922590",
                					"CodObjetivo": "71",
                					"SaldoAnterior": "$0",
                					"Aportes": "$0",
                					"Retiros": "$0",
                					"Transferencias": "$0",
                					"SaldoFinal": "$0"
                				}
                
                			]
                		},
                		"Observaciones": {
                			"Observacion": [
                				{
                					"texto": ""
                				}
                			]
                		}
                	}
                """;
        var extract = mapper.readValue(extractObject, Extracto.class);

        var response = ExtractoMapper.mapper(extract);

        assertNotNull(response);


    }

}