const body = document.querySelector('body')
const box = document.querySelector('p')
const yesBtn = document.getElementById('yes')
const noBtn = document.getElementById('no')
const sbtn = document.getElementById('Ok')
let count = 1;


const changeBackImg = (info) => {
    body.style.backgroundImage = "url('/img/MidJourney/quest/" + info +".png')"
}

sbtn.addEventListener("click" ,  () => {
    location.reload()
})


const firstRequest= () => {
    setTimeout(function () {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/controller",
            data: `{
              "count" : "0"
            }`,
            success: function (result) {
                box.textContent = result["202"]
                changeBackImg(result["imgId"])
            },
            dataType: "json"
        });

    }, 1000);
}
yesBtn.addEventListener('click', () => {
    console.log("sup yes")
    console.log(count)
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/controller",
        data: `{
           "count": "` + count + `",
            "btn" : "true"
        }`,
        success: function (result) {
            console.log(result)
            if (result.hasOwnProperty('200')) {
                box.textContent = result["200"]
                changeBackImg(result["imgId"])
            }
            if (result.hasOwnProperty('200')) {
                setTimeout(function() {
                    box.textContent = result["202"]
                    if (result.hasOwnProperty('endImgId')){
                        changeBackImg(result['endImgId'])
                    }
                }, 3000);
            }
            else {
                box.textContent = result["202"]
                changeBackImg(result["imgId"])
            }
            if (result.hasOwnProperty('transition')) {
                count = result['transition']
            }
            if (result.hasOwnProperty('end')) {
                sbtn.style.display = "block"
                yesBtn.style.display = "none"
                noBtn.style.display = "none"
            }
            count++
        },
        dataType: "json"
    });
})
noBtn.addEventListener('click', () => {
    console.log('sup no')
    console.log(count)
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/controller",
        data: `{
        "count": "` + count + `",
          "btn" : "false"
        }`,
        success: function (result) {
            console.log(result)
            if (result.hasOwnProperty('200')) {
                box.textContent = result["200"]
                changeBackImg(result["imgId"])
            }
            if (result.hasOwnProperty('200')) {
                setTimeout(function() {
                    box.textContent = result["202"]
                    if (result.hasOwnProperty('endImgId')){
                        changeBackImg(result['endImgId'])
                    }
                }, 3000);
            }
            else {
                box.textContent = result["202"]
                changeBackImg(result["imgId"])
            }
            if (result.hasOwnProperty('transition')) {
                count = result['transition']
            }
            if (result.hasOwnProperty('end')) {
                sbtn.style.display = "block"
                yesBtn.style.display = "none"
                noBtn.style.display = "none"
            }
            count++
        },
        dataType: "json"
    });
})