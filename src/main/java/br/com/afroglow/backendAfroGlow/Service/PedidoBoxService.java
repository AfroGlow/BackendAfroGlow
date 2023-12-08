package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.DTO.PedidoBoxRequestDTO;
import br.com.afroglow.backendAfroGlow.Models.PedidoBox;
import br.com.afroglow.backendAfroGlow.Repository.PedidoBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoBoxService {

    @Autowired
    private PedidoBoxRepository pedidoBoxRepository;

    public PedidoBox createPedidoBox(PedidoBoxRequestDTO pedidoBoxRequestDTO) {
        PedidoBox pedidoBox = mapPedidoBoxRequestDTOToPedidoBox(pedidoBoxRequestDTO);
        return pedidoBoxRepository.save(pedidoBox);
    }

    public Optional<PedidoBox> getPedidoBoxById(Integer pedidoBoxId) {
        return pedidoBoxRepository.findById(pedidoBoxId);
    }

    // Implemente métodos adicionais conforme necessário

    private PedidoBox mapPedidoBoxRequestDTOToPedidoBox(PedidoBoxRequestDTO pedidoBoxRequestDTO) {
        PedidoBox pedidoBox = new PedidoBox();
        pedidoBox.setIdUsuario(pedidoBoxRequestDTO.getIdUsuario());
        pedidoBox.setIdBox(pedidoBoxRequestDTO.getIdBox());
        pedidoBox.setIdPagamento(pedidoBoxRequestDTO.getIdPagamento());
        // Adicione outros mapeamentos conforme necessário
        return pedidoBox;
    }

    public boolean deletePedidoBox(Integer pedidoBoxId) {
        return false;
    }

    public Optional<PedidoBox> updatePedidoBox(Integer pedidoBoxId, PedidoBoxRequestDTO pedidoBoxRequestDTO) {
        return null;
    }

    public List<PedidoBox> getAllPedidosBox() {
        return null;
    }
}
