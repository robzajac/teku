/*
 * Copyright ConsenSys Software Inc., 2022
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.spec.config;

import java.util.Objects;
import java.util.Optional;
import tech.pegasys.teku.infrastructure.bytes.Bytes4;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;

public class SpecConfigEip4844Impl extends DelegatingSpecConfigCapella
    implements SpecConfigEip4844 {

  private final Bytes4 eip4844ForkVersion;
  private final UInt64 eip4844ForkEpoch;

  private final int fieldElementsPerBlob;
  private final int maxBlobsPerBlock;
  private final Optional<String> trustedSetupPath;
  private final boolean kzgNoop;

  public SpecConfigEip4844Impl(
      final SpecConfigCapella specConfig,
      final Bytes4 eip4844ForkVersion,
      final UInt64 eip4844ForkEpoch,
      final int fieldElementsPerBlob,
      final int maxBlobsPerBlock,
      final Optional<String> trustedSetupPath,
      final boolean kzgNoop) {
    super(specConfig);
    this.eip4844ForkVersion = eip4844ForkVersion;
    this.eip4844ForkEpoch = eip4844ForkEpoch;
    this.fieldElementsPerBlob = fieldElementsPerBlob;
    this.maxBlobsPerBlock = maxBlobsPerBlock;
    this.trustedSetupPath = trustedSetupPath;
    this.kzgNoop = kzgNoop;
  }

  @Override
  public Bytes4 getEip4844ForkVersion() {
    return eip4844ForkVersion;
  }

  @Override
  public UInt64 getEip4844ForkEpoch() {
    return eip4844ForkEpoch;
  }

  @Override
  public int getFieldElementsPerBlob() {
    return fieldElementsPerBlob;
  }

  @Override
  public int getMaxBlobsPerBlock() {
    return maxBlobsPerBlock;
  }

  @Override
  public Optional<String> getTrustedSetupPath() {
    return trustedSetupPath;
  }

  @Override
  public boolean isKZGNoop() {
    return kzgNoop;
  }

  @Override
  public Optional<SpecConfigEip4844> toVersionEip4844() {
    return Optional.of(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final SpecConfigEip4844Impl that = (SpecConfigEip4844Impl) o;
    return Objects.equals(specConfig, that.specConfig)
        && Objects.equals(eip4844ForkVersion, that.eip4844ForkVersion)
        && Objects.equals(eip4844ForkEpoch, that.eip4844ForkEpoch)
        && fieldElementsPerBlob == that.fieldElementsPerBlob
        && maxBlobsPerBlock == that.maxBlobsPerBlock
        && Objects.equals(trustedSetupPath, that.trustedSetupPath)
        && kzgNoop == that.kzgNoop;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        specConfig,
        eip4844ForkVersion,
        eip4844ForkEpoch,
        fieldElementsPerBlob,
        maxBlobsPerBlock,
        trustedSetupPath,
        kzgNoop);
  }
}
