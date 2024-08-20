const pieCanvas = document.getElementById("pieCanvas");

const pieChart = new Chart(pieCanvas , {
    type : "pie" ,
    data : {
        labels : [
            'Marketing',
            'Development'
        ],
        datasets : [
            {
                data : [300 , 100],
                backgroundColor : [
                    "rgb(255 , 99 , 132)",
                    "rgb(255 , 205 , 86)"
                ],
                hoverOffset : 4
            }
        ]
    }
})