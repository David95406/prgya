const {Builder, By, Key, until} = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');

async function example() {
    // Fej nélküli (headless) mód beállítása, ha szükséges
    let options = new chrome.Options().headless(); 
    let driver = await new Builder().forBrowser('chrome').setChromeOptions(options).build();
    
    try {
        // Böngészőablak méretének beállítása
        await driver.manage().window().setRect({ width: 1024, height: 768 });
        
        // Nyisd meg a Google weboldalt
        await driver.get('http://www.google.com');
        
        // Várakozás az elem elhelyezkedésére és láthatóvá válására
        let searchBox = await driver.wait(until.elementLocated(By.name('q')), 10000);  // Várakozás, amíg megtalálja a keresőmezőt
        await driver.wait(until.elementIsVisible(searchBox), 10000);  // Várakozás, amíg a keresőmező láthatóvá válik
        
        // Ellenőrizzük, hogy az elem tényleg interaktálható-e
        let isEnabled = await searchBox.isEnabled();
        let isDisplayed = await searchBox.isDisplayed();
        console.log(`Enabled: ${isEnabled}, Displayed: ${isDisplayed}`);

        // Ha az elem nem látható, megpróbáljuk láthatóvá tenni
        if (!isDisplayed) {
            await driver.executeScript("arguments[0].style.visibility='visible';", searchBox);
        }

        // Írás a keresőmezőbe, majd keresés
        await searchBox.sendKeys('Selenium', Key.RETURN);
        
        // Növeljük a várakozási időt, és rugalmasabbá tesszük a címet
        await driver.wait(until.titleContains('Selenium'), 5000);
    } finally {
        // Zárd be a böngészőt
        await driver.quit();
    }
}

example();
