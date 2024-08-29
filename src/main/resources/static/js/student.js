const FirstName = document.getElementById('FirstName');
const LastName = document.getElementById("LastName");
const Matricule = document.getElementById("Matricule");




const changeValueChampsMatricule = ()=>{
    console.log("OK");
    Matricule.value = FirstName.value.substring(0 , 2) + LastName.value.substring(0 , 1) + Math.floor(Math.random() * 1000);
}

