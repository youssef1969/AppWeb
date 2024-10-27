function formToJSON() {
	var formData = new FormData(document.getElementById('formAdd'));
	var jsonObject = {};
	formData.forEach(function(value, key) {
		if (key=="etudiants" || key=="profs") {
			jsonObject[key] = [{"id":"0","nom":value,"prenom":"testprenom"}];
		}
		else {
			jsonObject[key] = value;
		}
	});
	var jsonData = JSON.stringify(jsonObject);
	console.log(jsonData); // Afficher le JSON dans la console (pour le tester)
  	// Ici, vous pouvez envoyer le JSON à une API ou le traiter de toute autre manière
  	
  	const request = new Request("/AW/Test/add", 
  		{method : "POST", 
  		headers: new Headers({"content-type":"application/json"}), 
  		body: jsonData
  		});
  	fetch(request);
}