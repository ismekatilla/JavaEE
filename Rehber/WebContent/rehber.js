/**
 * 
 */
function kaydet() {

	metodName = "GUNCELLE";
	if($("#rehberTekilId").val() == undefined || $("#rehberTekilId").val() == null || $("#rehberTekilId").val() == "") {
		metodName = "EKLE";
	}
	
	$.post("ContollerServlet", {
		method: metodName,
		rehberId : $("#rehberTekilId").val(),
		isim : $("#isim").val(),
		tel : $("#tel").val()
	}, function(result) {
		listele();
	});
}

function listele() {
	clear();
	
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
			
			silTd = "<td><input type=\"button\" value='Sil' onclick='sil(" + id + ")' class='btn btn-info' /></td>";
			duzenleTd = "<td><input type=\"button\" value='Düzenle' onclick='duzenle(" + JSON.stringify(rehber) + ")' class='btn btn-danger' /></td>";
			tr = "<tr>" + duzenleTd + silTd + "<td>" + id + "</td><td>" + isim + "</td><td>" + telefon + "</td></tr>";
			$(".table tbody").append(tr);
		}
	});
}

function sil(id) {
	$.post("ContollerServlet", {
		method: "SIL",
		rehberId: id
	}, function(result) {
		listele();
	});
}

function duzenle(rehber) {
	
	$("#rehberTekilId").val(rehber.id);
	$("#isim").val(rehber.isim);
	$("#tel").val(rehber.telefon);
}

function clear() {
	$("#rehberTekilId").val(null);
	$("#isim").val(null);
	$("#tel").val(null);
}