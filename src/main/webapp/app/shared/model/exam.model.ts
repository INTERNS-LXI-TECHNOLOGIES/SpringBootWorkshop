export interface IExam {
  id?: number;
  question?: string;
  opt1?: string;
  opt2?: string;
  opt3?: string;
  opt4?: string;
  answer?: string;
}

export class Exam implements IExam {
  constructor(
    public id?: number,
    public question?: string,
    public opt1?: string,
    public opt2?: string,
    public opt3?: string,
    public opt4?: string,
    public answer?: string
  ) {}
}
