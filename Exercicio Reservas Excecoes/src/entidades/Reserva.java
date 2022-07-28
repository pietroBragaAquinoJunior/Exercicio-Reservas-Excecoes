package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecoes.ExcecaoDominio;

public class Reserva {

	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	private static Date now = new Date();
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) throws ExcecaoDominio {
		if(dataEntrada.before(now) || dataSaida.before(now)) {
			throw new ExcecaoDominio("As datas devem ser futurísticas.");
		}
		if(dataEntrada.after(dataSaida)) {
			throw new ExcecaoDominio("A data de saída deve ocorrer depois da data de entrada.");
		}
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date dataEntrada, Date dataSaida) throws ExcecaoDominio {
		if(dataEntrada.before(now) || dataSaida.before(now)) {
			throw new ExcecaoDominio("As datas devem ser futurísticas.");
		}
		if(dataEntrada.after(dataSaida)) {
			throw new ExcecaoDominio("A data de saída deve ocorrer depois da data de entrada.");
		}
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	@Override
	public String toString() {
		return "numeroQuarto=" + numeroQuarto + ", dataEntrada=" + sdf.format(dataEntrada) + ", dataSaida=" + sdf.format(dataSaida)+", Dias="+duracao();
	}
	
}
