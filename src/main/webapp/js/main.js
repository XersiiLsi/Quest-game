const body = document.querySelector('body')
const name = document.getElementById('name')
const profession = document.getElementById('profession')

function wordLength(word) {
    const num = word.textContent.length
    word.setAttribute('style' , '--typewriterCharacters:'+ num + ' ')
}
wordLength(name)
wordLength(profession)


function getRandomInt () {
    return Math.floor(Math.random() * 10);
}

const perfomance = () => {
    changeImageSuit()
    setTimeout(function() {
        changeImageGo()
    }, 5000);
    setTimeout(function() {
        changeImageCrash()
    }, 15000);
    setTimeout(function() {
        changeImageBeach()
    }, 18000);
}
const changeImageSuit = () => {
    number = getRandomInt()
    if (number === 0) {
        number = getRandomInt()
    }
    if (number === 0) {
        number = getRandomInt()
    }
    body.style.backgroundImage = "url('/img/MidJourney/startImages/packingSuitcase/suitcase" + number +".png')"
}

const changeImageGo = () => {
    number = getRandomInt()
    if (number === 0) {
        number = getRandomInt()
    }
    body.style.backgroundImage = "url('/img/MidJourney/startImages/walkToPlane/walk" + number +".png')"
}

const changeImageCrash = () => {
    number = getRandomInt()
    if (number === 0) {
        number = getRandomInt()
    }
    body.style.backgroundImage = "url('/img/MidJourney/startImages/crashingPlane/crash" + number +".png')"
}

const changeImageBeach = () => {
    number = getRandomInt()
    if (number === 0) {
        number = getRandomInt()
    }
    body.style.backgroundImage = "url('/img/MidJourney/startImages/planeOnBeach/plane" + number +".png')"
}

$(document).ready(function(){
    $.fn.animate_Text = function() {
        var string = this.text();
        return this.each(function(){
            var $this = $(this);
            $this.html(string.replace(/./g, '<span class="new">$&</span>'));
            $this.find('span.new').each(function(i, el){
                setTimeout(function(){ $(el).addClass('div_opacity'); }, 20 * i);
            });
        });
    };
    setTimeout(function() {
        $('#smooth-effect').show();
        $('#smooth-effect').animate_Text();
    }, 5500);
});



