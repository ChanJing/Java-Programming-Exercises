public class JsonCreater{
	public static void main(String[] args){
		JsonCreater jc = new JsonCreater();
		jc.go();
	}

	public void go(){

		String json = "[{\"date\":\"May 22\",";
		json = json + "\"movies\":[";
		for(int i = 0; i < 5; i++){
			json = json + "{";

			//Useless
			json = json + "\"countries\":[\"USA\"],\"directors\":[{\"name\":\"Brad Bird\",\"nameId\":\"nm0083348\"}],\"filmingLocations\":[\"Vancouver\",\"British Columbia\",\"Canada\"],\"genres\":[\"Action\",\"Adventure\",\"Mystery\",\"Sci-Fi\"],\"idIMDB\":\"tt1964418\",\"languages\":[\"English\"],\"metascore\":\"66/100\",\"originalTitle\":\"asdf\",";
			json = json + "\"runtime\":[\"130 min\"],\"simplePlot\":\"Boundy.\",\"urlIMDB\":\"http://www.imdb.com/title/tt1964418\",";


			json = json + "\"title\":";
			json = json + "\"balabala\",";

			json = json + "\"plot\":";
			json = json + "\"balabala\",";

			json = json + "\"rated\":";
			json = json + "\"balabala\",";

			json = json + "\"rating\":";
			json = json + "\"balabala\",";

			json = json + "\"releaseDate\":";
			json = json + "\"balabala\",";

			json = json + "\"urlPoster\":";
			json = json + "\"balabala\",";

			//Useless
			json = json + "\"votes\":\"985\",\"writers\":[{\"name\":\"Damon Lindelof\",\"nameId\":\"nm0511541\"},{\"name\":\"Brad Bird\",\"nameId\":\"nm0083348\"}],\"year\":\"2015\"";

			json = json + "},";
		}

		json = json + "]}]";

		System.out.println(json);
	}
}