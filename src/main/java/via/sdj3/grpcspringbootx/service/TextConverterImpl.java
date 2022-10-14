package via.sdj3.grpcspringbootx.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sdj3.grpcspringbootx.protobuf.RequestText;
import via.sdj3.grpcspringbootx.protobuf.ResponseText;
import via.sdj3.grpcspringbootx.protobuf.TextConverterGrpc;

@GRpcService
public class TextConverterImpl extends TextConverterGrpc.TextConverterImplBase {
    @Override
    public void toUpper(RequestText request, StreamObserver<ResponseText> responseObserver) {
        // super.toUpper(request, responseObserver);
        System.out.println("Received Request ====> " + request.toString());
        ResponseText responseText = ResponseText.newBuilder()
                .setOutputText(request.getInputText().toUpperCase()).build();
        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }

    @Override
    public void capitalizeFirstCharacter(RequestText request, StreamObserver<ResponseText> responseObserver) {
        // super.capitalizeFirstCharacter(request, responseObserver);
        System.out.println("Received Request ====> " + request.toString());
        String res = Character.toUpperCase(request.getInputText().charAt(0))
                + request.getInputText().substring(1).toLowerCase();
        ResponseText responseText = ResponseText.newBuilder()
                .setOutputText(res).build();
        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }
}
