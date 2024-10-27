const listeGroupe = ["2SN","2SNA","2SNB","2SNM","2SNL","2SNR","2SNT"];
const listeProf = ["PANTEL Marc", "CHAPUT Emmanuel", "HAGIMONT Daniel"];

const inputreel = document.getElementById("inputreel");

// let zf = document.getElementById("zf");

document.getElementsByClassName("inputZoneFlex")[0].addEventListener("click", function (e) {
    inputreel.focus();
})

autocomplete(inputreel,listeGroupe);

function autocomplete(input,list) {
    let currentFocus = -1;
    const IDList = this.id+"-listeG"
    input.addEventListener("input", function(e) {
        closeList(IDList);
        let val = this.value;
        if (val) {
            let listeG = document.createElement("ul");
            const zoneFlowroot = this.parentElement.children[this.parentElement.children.length-1];
            zoneFlowroot.appendChild(listeG);
            listeG.classList.add("olGroupe");
            listeG.setAttribute("id",IDList);
            let item;
            for (const g of listeGroupe) {
                if (g.substring(0, val.length).toUpperCase() == val.toUpperCase()) {
                    item = document.createElement("li");
                    item.classList.add("liGroupe");
                    item.innerHTML = g;
                    item.innerHTML += "<input type='hidden' value='" + g + "'>";
                    item.addEventListener("click", function(e) {
                        let g = addG(this.getElementsByTagName("input")[0].value);
						let p = input.parentElement;
                        p.insertBefore(g, p.childNodes[p.children.length-1]);
                        closeList(IDList);
                        inputreel.value="";
                    })
                    listeG.appendChild(item);
                }
            }
        }
    })

    /*execute a function presses a key on the keyboard:*/
    input.addEventListener("keydown", function(e) {
    let x = document.getElementById(IDList);
    if (x) x = x.getElementsByTagName("li");
    if (e.key == "ArrowDown") {
        /*If the arrow DOWN key is pressed,
        increase the currentFocus variable:*/
        removeActive(x,currentFocus);
        currentFocus++;
        /*and and make the current item more visible:*/
        currentFocus = addActive(x,currentFocus);
    } else if (e.key == "ArrowUp") { //up
        /*If the arrow UP key is pressed,
        decrease the currentFocus variable:*/
        removeActive(x,currentFocus);
        currentFocus--;
        /*and and make the current item more visible:*/
        currentFocus = addActive(x,currentFocus);
    } else if (e.key == "Enter") {
        /*If the ENTER key is pressed, prevent the form from being submitted,*/
        e.preventDefault();
        if (currentFocus > -1) {
            /*and simulate a click on the "active" item:*/
            if (x) x[currentFocus].click();
            currentFocus=-1;
        }
        else input.blur();
    } 
    });
}


function addActive(x,currentFocus) {
    /*a function to classify an item as "active":*/
    if (!x) return false;
    let newFocus=currentFocus;
    if (currentFocus >= x.length) newFocus = 0;
    if (currentFocus < 0) newFocus = (x.length - 1);
    x[newFocus].classList.add("liGroupeActif");
    return newFocus;
}
function removeActive(x,currentFocus) {
    /*a function to remove the "active" class */
    if (!x) return false;
    /*start by removing the "active" class on all items:*/
    if (currentFocus>=0) {
        x[currentFocus].setAttribute("class","liGroupe");
    }
}

//return l'elem a lier avec son daron
function addG(nom) {
    let gelement = document.createElement("div");
    gelement.innerHTML=nom;
    gelement.innerHTML += "<input class='nGroupe' type='hidden' value='" + nom + "'>";
    gelement.classList.add("gelement");
    gelement.setAttribute("id",nom);
    let btnDelete = document.createElement("ion-icon");
    btnDelete.setAttribute("name","close-outline");
    btnDelete.setAttribute("class","deleteIcon");
    gelement.appendChild(btnDelete)
    btnDelete.addEventListener("click", function(e) {
        gelement.remove();
    })
    return gelement;
}
function closeList(IDlistToClose) {
    if(document.getElementById(IDlistToClose)) document.getElementById(IDlistToClose).remove();
}

function deleteG(btn) {
    let item=btn.parentElement;
    item.remove();
}

function groupListToJSON(){
    let allG = zf.getElementsByClassName("nGroupe");
    let list = [];
    for (const elem of allG) {
        list.push(elem.value);
    }
    return JSON.stringify(list);
}

function sendForm() {
    //Check min un groupe
    if (zf.children.length<=1) {
        alert("Must chose at least one group");
    }
    else {
        let listGroup = groupListToJSON();
    }
}



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