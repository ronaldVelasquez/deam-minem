package pe.gob.minem.deam.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pe.gob.minem.deam.model.DenunciaEntity;

/**
 * Created by ronaldvelasquez on 2/01/17.
 */

public class ListDenunciaResponse {
    @SerializedName("denuncias")
    private List<DenunciaEntity> listDenuncia;

    public List<DenunciaEntity> getListDenuncia() {
        return listDenuncia;
    }

    public void setListDenuncia(List<DenunciaEntity> listDenuncia) {
        this.listDenuncia = listDenuncia;
    }
}
