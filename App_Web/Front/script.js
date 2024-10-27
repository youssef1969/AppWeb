const unJour = 86400000; // ms en un jour



function dayNumberToText(num) {
    switch (num) {
        case 1: return "lun";
        case 2: return "mar";
        case 3: return "mer";
        case 4: return "jeu";
        case 5: return "ven";
        default : return "";
    }
}

function monthNumberToText(num) {
    switch (num) {
        case 0: return "Janvier";
        case 1: return "Fevrier";
        case 2: return "Mars";
        case 3: return "Avril";
        case 4: return "Mai";
        case 5: return "Juin";
        case 6: return "Juillet";
        case 7: return "Août";
        case 8: return "Septembre";
        case 9: return "Octobre";
        case 10: return "Novembre";
        case 11: return "Decembre";
        default: return "";
    }
}


//Clear tous les cours presents
function clearCalendar() {
    const listJ = ["lunGrid","marGrid","merGrid","jeuGrid","venGrid"];
    for (const j of listJ) {
        const elem = document.getElementById(j);
        while (elem.firstChild) {
            elem.removeChild(elem.firstChild);
        }
    }
}


//Recuperer Date du jour
//Selectionner le jour en blue
//Afficher les nombres des jours en fct de la date en param
function setUpWeekNumbers(date) {
    const numJour = date.getDay();
    const today = new Date();
    const sunday = new Date(date.getTime() - unJour*numJour); 

    //mise en valeur de la date ajd
    const res = dayNumberToText(numJour);
    if (res!="") {
        if (date.getDate()==today.getDate() && date.getMonth()==today.getMonth() && date.getFullYear()==today.getFullYear()) {
            document.getElementById(res).classList.add("selected");

        }
        else {
            document.getElementById(res).classList.remove("selected");
        }
    }

    //a partir de dimanche
    const list= ["lunJ","marJ","merJ","jeuJ","venJ"];
    let jour = new Array(5);

    let jour_num = 0;
    for (let i=0;i<5;i++) {
        jour[i] = new Date(sunday.getTime() + unJour*(i+1));
        document.getElementById(list[i]).textContent = jour[i].getDate();
    }
}


function setUpMonth(date) {
    document.getElementById("dateMonth").textContent = monthNumberToText(date.getMonth()) + " " + date.getFullYear();
}

let current = new Date(); // Init à jour ajd
setUpWeekNumbers(current);
setUpMonth(current);

function mvBtnAction(direction) {
    const dir = direction=='b' ? -7 : 7;
    current = new Date(current.getTime() + dir*unJour);
    setUpWeekNumbers(current);
    setUpMonth(current);
    clearCalendar();
}

function returnTodayBtnAction() {
    current = new Date();
    setUpWeekNumbers(current);
    setUpMonth(current);
}
