package eurostat.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import eurostat.entities.TimeFramed;

@Entity
@Table(name="playerstatdates")
public class PlayerStatDate implements TimeFramed{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="playerstatdates_generator")
	@SequenceGenerator(name="playerstatdates_generator", sequenceName = "playerstatdates_seq", allocationSize = 1)
	@Column(name = "playerstatdate_id")
	private long playerStatDateId;
	
	@Size(min=1)
	@Transient
	private List<String> names;
	
	private String players;

	
	@NotNull
	@Column(name="column_name")
	private String column;
	
	@NotNull (message="Пожалуйста, выберите даты")
	private int fromDate;
	
	@NotNull (message="Пожалуйста, выберите даты")
	private int toDate;
	private boolean showAverage;
	@Column(name = "playerstatdate_name")
	private String playerStatDateName;
	private String userName;

	

	public long getPlayerStatDateId() {
		return playerStatDateId;
	}

	public void setPlayerStatDateId(long playerStatDateId) {
		this.playerStatDateId = playerStatDateId;
	}

	public String getPlayerStatDateName() {
		return playerStatDateName;
	}

	public void setPlayerStatDateName(String playerStatDateName) {
		this.playerStatDateName = playerStatDateName;
	}

	public boolean isShowAverage() {
		return showAverage;
	}

	public void setShowAverage(boolean showAverage) {
		this.showAverage = showAverage;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	public void setNames() {
		this.names = toList(this.players);
	}
	
	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}
	
	public void setPlayers() {
		this.players = toJString(this.names);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public int getFromDate() {
		return fromDate;
	}

	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}

	public int getToDate() {
		return toDate;
	}

	public void setToDate(int toDate) {
		this.toDate = toDate;
	}


	public PlayerStatDate(List<String> names, String column, int fromDate, int toDate, boolean showAverage,
			String playerStatDateName) {
		super();
		this.names = names;
		this.players = toJString(names);
		this.column = column;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.showAverage = showAverage;
		this.playerStatDateName = playerStatDateName;
	}
	
	
	
	public PlayerStatDate(String players, @NotNull String column,
			int fromDate,
			int toDate, boolean showAverage,
			String playerStatDateName) {
		super();
		this.players = players;
		this.names = toList(players);
		this.column = column;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.showAverage = showAverage;
		this.playerStatDateName = playerStatDateName;
	}

	public String interpretSelectedColumn()
	{
		String stats = "";
		switch (this.getColumn()) 
		{
			case "getTimePlayed": stats = "Time played"; break;
			case "getScore": stats = "Points scored"; break;
			case "getShots2": stats = "2-pt attempts"; break;
			case "getScored2": stats = "2-pt attempts scored"; break;
			case "getShots3": stats = "3-pt attempts"; break;
			case "getScored3": stats = "3-pt attempts scored"; break;
			case "getShots1": stats = "Free throws"; break;
			case "getScored1": stats = "Free throws scored"; break;
			case "getReboundsDefensive": stats = "Defensive rebounds"; break;
			case "getReboundsOffensive": stats = "Offensive rebounds"; break;
			case "getRebounds": stats = "Rebounds in total"; break;
			case "getPasses": stats = "Assists on goal"; break;
			case "getInterceptions": stats = "Interceptions"; break;
			case "getTurnovers": stats = "Turnovers"; break;
			case "getBlocks": stats = "Block shots made"; break;
			case "getBlocked": stats = "Got blocked"; break;
			case "getFouls": stats = "Fouls committed"; break;
			case "getFouled": stats = "Got fouled"; break;
			case "getIndex": stats = "Performance index";  break;
			case "getShots2Accuracy": stats = "2pt accuracy";  break;	
			case "getShots3Accuracy": stats = "3pt accuracy";  break;
			case "getShots1Accuracy": stats = "FT accuracy"; break;
		}
		return stats;
	}

	@Override
	public String toString() {
		String result = new String();
		for (String i : names) {
			result += i + ",";
		}
		return result.substring(0, result.length()-1);
	}
	
	public static List<String> toList(String input) {
		List<String> result = new ArrayList<>(Arrays.asList(input.split(",")));
		return result;
		
	}
	
	public static String toJString (List<String> input) {
		String result = new String();
		for (String i : input) {
			result += i + ",";
		}
		return result.substring(0, result.length()-1);
	}
	
	public PlayerStatDate() {
	}
	
	
}
