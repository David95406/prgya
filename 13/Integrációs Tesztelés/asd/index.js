const { Builder, By, Key, until } = require('selenium-webdriver');
async function example() {
    let driver = await new Builder().forBrowser('chrome').build();
    try {
        // Nyiss meg egy weboldalt
        await driver.get('http://www.vanenet.hu/');
        // Keress valamit a Google-ben
        await driver.findElement(By.name('q')).sendKeys('Selenium',
            Key.RETURN);
        // Várd meg, hogy megjelenjenek az eredmények

        await driver.wait(until.titleIs('Selenium - GoogleSearch'), 1000);
    } finally {
        // Zárd be a böngészőt
        await driver.quit();
    }
}
example();