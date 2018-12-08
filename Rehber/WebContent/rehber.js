/**
 * 
 */
function kaydet() {

	$.post("ContollerServlet", {
		method: "EKLE",
		isim : $("#isim").val(),
		tel : $("#tel").val()
	}, function(result) {
		rehber = JSON.parse(result);
		listele();
	});
}

function listele() {
	$.post("ContollerServlet", {
		method: "GETIR"
	}, function(result) {
		rehberList = JSON.parse(result);
		$(".table tbody").empty();
		for (i = 0; i < rehberList.length; i++) {
			rehber = rehberList[i];
			id = rehber.id;
			isim = rehber.isim;
			telefon = rehber.telefon;
			
			tr = "<tr><td>" + id + "</td><td>" + isim + "</td><td>" + telefon + "</td></tr>";
			$(".table tbody").append(tr);
		}
	});
}