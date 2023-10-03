const body = document.querySelector('body')
const suitImg =  ['packagingSuit', 'weekendSuitcase', 'suitcaseInOffice', 'geographerSuit' , 'teaSuitcase' ]
const walkImg = ['beautifulWalk', 'walkToPlainAlone', 'walkAtSunset', 'favouriteWalk', 'walkLikeAnimation', 'walkInDark', 'usWalk']
const crashImg = ['funCrash', 'LOLCrash', 'darkCrasher', 'cloudsCrash', 'fireCrash', 'interestingCrash', 'crashBoom', 'crashOnAir' ]
const jungleImg = ['onlyPlane', 'forestPlane', 'jungleView']

function getRandom (array) {
    return Math.floor(Math.random() * array.length);
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
    body.style.backgroundImage = "url('/img/MidJourney/startImages/packingSuitcase/" + suitImg[getRandom(suitImg)] +".png')"
}

const changeImageGo = () => {
    body.style.backgroundImage = "url('/img/MidJourney/startImages/walkToPlane/" + walkImg[getRandom(walkImg)] +".png')"
}

const changeImageCrash = () => {
    body.style.backgroundImage = "url('/img/MidJourney/startImages/crashingPlane/" + crashImg[getRandom(crashImg)] +".png')"
}

const changeImageBeach = () => {
    body.style.backgroundImage = "url('/img/MidJourney/startImages/planeOnBeach/" + jungleImg[getRandom(jungleImg)] +".png')"
}