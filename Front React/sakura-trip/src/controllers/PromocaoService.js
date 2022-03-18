import axios from "axios";

const PROMOCAO_API_URL = 'http://localhost:8080/promocoes'

class PromocaoService {
  getAllPromocoes() {
    return axios.get(PROMOCAO_API_URL);
  }

  createPromocao(promocao) {
    return axios.post(PROMOCAO_API_URL, promocao);
  }

  getPromocaoById(promocaoId) {
    return axios.get(PROMOCAO_API_URL + "/" + promocaoId);
  }

  updatePromocao(promocaoId, promocao) {
    return axios.put(PROMOCAO_API_URL + "/" + promocaoId, promocao);
  }

  deletePromocao(promocaoId) {
    return axios.delete(PROMOCAO_API_URL + "/" + promocaoId);
  }
}

export default new PromocaoService();
