# Jetpack Compose Battle - Qualify Round
Jetpack Compose Battle เป็นงานแข่งขันที่จะให้นักพัฒนาแอนดรอยด์ในประเทศไทยแข่งกันสร้าง UI ด้วย Jetpack Compose ที่เป็น UI Framework ตัวใหม่ล่าสุดทางทีมแอนดรอยด์

## รายละเอียดสำหรับรอบคัดเลือก
* การเข้าร่วมแข่งขันในรอบคัดเลือกสามารถเริ่มทำโจทย์ได้ตั้งแต่วันที่ 17 มกราคม 2024 จนถึงวันหมดเขต
* ผู้เข้าแข่งขันจะต้องสร้าง UI ด้วย Jetpack Compose ในแต่ละข้อให้ถูกต้องตามที่กำหนดไว้ใน Figma
* คะแนนจะถูกคำนวณจากความถูกต้องของ UI โดยตรวจสอบจาก Snapshot Testing
* การแข่งขันในรอบคัดเลือกจะหมดเขตภายในวันที่ 24 มกราคม 2024 เวลา 23:59 น. และผลการแข่งขันจะประกาศภายในวันที่ 31 มกราคม 2024
* ผู้ที่เข้ารอบคัดเลือกจะได้ไปแข่งขันในรอบสุดท้าย ณ วันเสาร์ที่ 17 กุมภาพันธ์ 2024 ที่จะจัดขึ้นที่บริษัท MuvMi

## ของรางวัล
* อันดับที่ 1 Android Mini Collectible @Work Series - Tech Support / IT / Engineer
![รางวัลอันดับที่ 1](images%2Fprize_first.png)

* อันดับที่ 2 Android Mini Collectible @Work Series - Developer / Coder / Cyber Security
![รางวัลอันดับที่ 2](images%2Fprize_second.png)

* อันดับที่ 3 หนังสือ The Team That Built the Android Operating System ของ Chet Haase
![รางวัลอันดับที่ 3](images%2Fprize_third.png)

* อันดับที่ 4 หุ่นยนต์ไขลาน Android Wind-up
![รางวัลอันดับที่ 4](images%2Fprize_fourth.png)

นอกจากนี้ผู้เข้าแข่งขันในรอบสุดท้ายทุกท่านจะได้รับของสมนาคุณจากบริษัท MuvMi อีกด้วย

## กติการในรอบคัดเลือก
1. ผู้เข้าแข่งขันจะต้องสร้าง UI ด้วย Jetpack Compose ที่ Fork จาก Repository นี้เท่านั้น
2. UI ที่จะต้องสร้างมีทั้งหมด 3 หน้าด้วยกัน สามารถดูได้จาก Figma -> [โจทย์รอบคัดเลือก](https://www.figma.com/file/AsOdXenDJAp89aTxGT996v/Jetpack-Compose-Battle---Qualify-Day?type=design&node-id=54766%3A246&mode=dev)
3. โจทย์มีทั้งหมด 3 ข้อ โดยจะอยู่ในไฟล์ดังนี้
   * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify1Screen.kt`
   * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify2Screen.kt`
   * `<project>/common/src/main/java/com/github/thailandandroiddeveloper/common/ui/screen/Qualify3Screen.kt`
4. สามารถสร้าง Composable Function เพิ่มในไฟล์ดังกล่าวได้ตามใจชอบ ขอแค่ห้ามแก้ไขข้อมูลใน `@Preview` ที่อยู่ในไฟล์ดังกล่าวก็พอ 
5. ห้ามใช้รูปภาพจากภายนอก ให้ใช้รูปที่เตรียมไว้ในโปรเจคนี้เท่านั้น โดยจะอยู่ที่ `<project>/common/src/main/res`
6. ชื่อไฟล์รูปภาพทั้งหมดให้ดูชื่อจากใน Figma และเรียกใช้งานผ่าน Android Resource ได้เลย
7. ค่าต่าง ๆ เช่น ขนาด ฟอนต์ ความหนาของตัวอักษรไม่ต้องสร้างขึ้นมาเอง ให้ดูจากใน Figma และเรียกใช้งานผ่าน `MaterialTheme` ได้เลย ยกตัวอย่างเช่น `MaterialTheme.typography.headlineMedium.fontSize` เป็นต้น
8. ค่าสีที่ใช้ใน UI ไม่ต้องสร้างขึ้นมาเอง ให้ดูจากใน Figma และเรียกใช้งานผ่าน `MaterialTheme` ได้เลย เช่น `MaterialTheme.colors.primary` เป็นต้น
9. คะแนนจะถูกคำนวณจากการรัน Snapshot Testing ด้วย Paparazzi โดยผู้เข้าแข่งขันสามารถทดสอบได้ด้วยการใช้คำสั่ง `./gradlew :screenshot-test:verifyPaparazziDebug` เผื่อดูผลลัพธ์ได้ก่อนส่งโจทย์
   * โดยผลลัพธ์ที่ได้จะอยู่ใน `<project>/screenshot-test/diff/` ที่จะบอกผลต่างของภาพที่ได้จากโค้ดเทียบกับภาพที่ถูกต้อง
   * ค่าที่ได้จากผลของ Snapshot Testing จะมีค่าเป็น % เมื่อเทียบกับภาพต้นฉบับ
   * ถ้าที่ได้มีค่าเท่ากับ 0 แปลว่าผลลัพธ์ถูกต้องแบบ 100%
10. ภาพต้นฉบับที่ใช้เปรียบเทียบใน Snapshot Testing จะอยู่ใน `/screenshot-test/src/test/snapshots/images` (ห้ามแก้ไข)

## การส่งโจทย์
* ให้ส่งโจทย์เป็น GitHub URL แล้วกรอกข้อมูลส่วนตัวพร้อมกับ URL ดังกล่าว -> [ลิ้งนี้]()
* สามารถทำเป็น Private Repository เพื่อความสบายใจได้ แต่จะต้องเชิญทีมงานเข้าไปใน Repository ดังกล่าวด้วย
  * `judrummer` หรือ `Tipatai Puthanukunkit`
  * `akexorcist` หรือ `Akexorcist`

## Sponsors
* [MuvMi](https://muvmi.co/)
* [LINE MAN Wongnai](https://lmwn.com/)
