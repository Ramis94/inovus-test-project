function getDay(){
    var hours = new Date().getHours();

    if (0 <= hours && hours < 6){
        document.getElementById('day').innerHTML = "Доброй ночи, ";
    } else if(6 <= hours && hours < 10){
        document.getElementById('day').innerHTML = "Доброе утро, ";
    } else if (10 <= hours && hours < 18) {
        document.getElementById('day').innerHTML = "Добрый день, ";
    } else if (18 <= hours && hours < 22) {
        document.getElementById('day').innerHTML = "Добрый вечер, ";
    } else if (22 <= hours && hours <= 24) {
        document.getElementById('day').innerHTML = "Доброй ночи, ";
    }
}