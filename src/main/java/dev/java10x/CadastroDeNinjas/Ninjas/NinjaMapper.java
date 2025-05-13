package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Component;

@Component
public class NinjaMapper{

    public NinjaModel map(NinjaDTO ninjaDTO){

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjamodel){
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setNome(ninjamodel.getNome());
        ninjaDTO.setEmail(ninjamodel.getEmail());
        ninjaDTO.setRank(ninjamodel.getRank());
        ninjaDTO.setMissoes(ninjamodel.getMissoes());
        ninjaDTO.setImgUrl(ninjamodel.getImgUrl());
        ninjaDTO.setIdade(ninjamodel.getIdade());
        ninjaDTO.setId(ninjamodel.getId());

        return ninjaDTO;
    }
}
