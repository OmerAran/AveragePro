interface IPro {
    _id: number
    name: string
    workHours: string
    workEnv: string
    salary:number
    status: boolean
  }

  interface TodoProps {
    pro: IPro
  }

  type ApiDataType = {
    message: string
    status: string
    pros: IPro[]
    pros?: IPro
  }
  