package com.emc.object.s3;

import com.emc.object.s3.jersey.S3JerseyClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;

public class Sdk238V4Test extends Sdk238Test{
    @Override
    @Test
    public void testTrailingSlash() throws Exception {
        S3Config s3Config = AbstractS3ClientTest.s3ConfigFromProperties();
        Sdk238V4Test.TestClient client = new Sdk238V4Test.TestClient(s3Config);

        String bucket = "test-trailing-slash-v4";
        client.createBucket(bucket);
        try {
            if (s3Config.isUseVHost()) {
                Assertions.assertEquals("/", client.getLastUri().getPath());
            } else {
                Assertions.assertEquals("/" + bucket, client.getLastUri().getPath());
            }
        } finally {
            client.deleteBucket(bucket);
        }
    }

    private class TestClient extends S3JerseyClient {
        private UriCaptureFilter captureFilter = new UriCaptureFilter();

        TestClient(S3Config s3Config) {
            super(s3Config.withUseV2Signer(false));
        }

        URI getLastUri() {
            return captureFilter.getLastUri();
        }
    }
}
