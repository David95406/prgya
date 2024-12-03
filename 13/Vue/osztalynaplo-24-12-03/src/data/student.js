/*
Magyarázat:
id: Egyedi azonosító a diák számára.
name: A diák neve.
class: Az osztálya (pl. 10.A).
grades: A diák jegyei egy tömbben tárolva.
absences: A diák hiányzásainak száma.
*/

const students = [
  {
    id: 1,
    name: "Kovács Anna",
    class: "10.A",
    grades: [5, 4, 3, 5],
    absences: 2,
  },
  {
    id: 2,
    name: "Nagy Péter",
    class: "10.B",
    grades: [3, 2, 4],
    absences: 5,
  },
  {
    id: 3,
    name: "Szabó Júlia",
    class: "10.A",
    grades: [4, 4, 4, 5],
    absences: 1,
  },
  {
    id: 4,
    name: "Tóth László",
    class: "10.C",
    grades: [2, 3, 2],
    absences: 8,
  },
  {
    id: 5,
    name: "Horváth Eszter",
    class: "10.B",
    grades: [5, 5, 4],
    absences: 0,
  },
  {
    id: 6,
    name: "Varga Gábor",
    class: "10.C",
    grades: [3, 3, 4],
    absences: 3,
  },
];

export default students;
