import axios, { AxiosResponse } from "axios"

const baseUrl : string = "http://localhost:8080"

export const getPro = async (_id : number): Promise<AxiosResponse<ApiDataType>> => {
    try {
      const pro: AxiosResponse<ApiDataType> = await axios.get(
        `${baseUrl}/pro/avgsalary/${_id}`
      )
      return pro
    } catch (error) {
      throw new Error()
    }
  }
